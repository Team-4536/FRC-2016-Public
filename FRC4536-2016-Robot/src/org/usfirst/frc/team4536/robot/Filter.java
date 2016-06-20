package org.usfirst.frc.team4536.robot;


import java.util.ArrayList;
import java.lang.Math;
import java.util.Collections;

public class Filter {
	
	ArrayList <Double> filter;
	double startTime = 0.0;
	double duration = 0.0;
	
	/**
	 * @author Liam
	 * Default Constructor with a sample size of 11 data points
	 */
	public Filter() {
		
		filter = new ArrayList<Double>(Constants.DEFAULT_SAMPLE_SIZE);
	}
	
	/**
	 * @author Liam
	 * @param sampleSize the number of data points to be sampled
	 */
	public Filter(int sampleSize) {
		
		filter = new ArrayList<Double>(sampleSize);
	}
	
	/**
	 * @author Liam
	 * @param startTime the clock time
	 * @param duration the duration over which data is sampled
	 */
	public Filter(double startTime, double duration) {
		
		this();
		this.startTime = startTime;
		this.duration = duration;
	}
	
	/**
	 * @author Liam
	 * @param duration the duration over which data is sampled
	 */
	public Filter(double duration) {
		
		this();
		this.duration = duration;
	}
	
	/**
	 * @author Liam
	 * @param value the value added to the sample
	 */
	public void update(double value) {
		
		//Possible logic:
		//(calculateZScore(value) > 5) ? 
		filter.add(value);
		Collections.sort(filter);
	}
	
	/**
	 * @author Liam
	 * @return the size of the sample
	 */
	public int size() {
		
		return filter.size();
	}
	
	/**
	 * @author Liam
	 * @param index the index in the sample
	 * @return the value at the index in the sample
	 */
	public double get(int index) {
		
		return filter.get(index);
	}
	
	/**
	 * @author Liam
	 * @return the first most frequently occurring value in the sample
	 */
	public double getMode() {
		
		short modeIndex = 0;
		short freq = 1;
		short valFreq = 0;
		for (int i = 1; i < filter.size(); i++) {
			
			if (filter.get(i).equals(filter.get(i-1))) {
				
				freq++;
				
				if (freq > valFreq) {
					
					valFreq = freq;
					modeIndex = (short) (i-1);
				}
			}
			else {
				
				if (freq > valFreq) {
					
					valFreq = freq;
					modeIndex = (short) (i-1);
				}
				
				freq = 1;
			}
		}
		
		return filter.get(modeIndex);
	}
	
	/**
	 * @author Liam
	 * @return the median value of the sample
	 */
	public double getMedian() {
		
		if ((filter.size() % 2) == 1) {
			
			return filter.get((int)(filter.size()/2));
		}
		
		return (filter.get((int) (filter.size()/2)) + filter.get((int) (filter.size()/2)-1))/2;
	}
	
	/**
	 * @author Liam
	 * @return the average value of the sample
	 */
	public double getMean() {
		
		double sum = 0.0;
		
		for (int i = 0; i < filter.size(); i ++) {
			
			sum += filter.get(i);
		}
		
		return sum / filter.size();
	}
	
	/**
	 * @author Liam
	 * @return the standard deviation of the sample
	 * within one standard deviation (~68%), within two (~96%), within three ~100%
	 */
	public double getStandardDeviation() {
		
		double sigma = 0.0; //sum
		double mean = getMean();
		double standardDeviation = 0.0;
		
		for (int i = 0; i < filter.size(); i++) {
			
			sigma += Math.pow(filter.get(i)-mean, 2);
		}
		
		standardDeviation = Math.sqrt(sigma/filter.size());
		
		return standardDeviation;
	}
	
	/**
	 * @author Liam
	 * @return the variance of the sample
	 */
	public double getVariance() {
		
		return Math.pow(getStandardDeviation(), 2);
	}
	
	/**
	 * @author Liam
	 * @return the range of the values from the data points in the sample
	 */
	public double getRange() {
		
		if (filter.size() > 0) {
			
			return filter.get(filter.size()-1) - filter.get(0);
		}
		
		return 0;
	}
	
	/**
	 * @author Liam
	 * @param value the new data point
	 * @return the Z-Score of the new data point
	 */
	public double calculateZScore(double value) {
		
		return (value - getMean())/getStandardDeviation();
	}
	
	
	
	/**
	 * @author Liam
	 * Overrides the default object toString() method. Returns all the data points in the sample in CSV (Comma Separated Value) format
	 */
	public String toString() {
		
		String data = "";
		
		for (int i = 0; i < filter.size(); i++) {
			
			data += filter.get(i) + ",";
		}
		
		return data;
	}
}
