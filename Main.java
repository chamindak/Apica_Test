package com.apica;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
	
	public static void main(String[] args) {
		String result = "";
		ArrayList<String> result_list = new ArrayList<>();
		
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in)); 
         
        try {
        	//Read input data
			String input_string = reader.readLine();
			String from_string = reader.readLine();
			String to_string = reader.readLine();
			
			//Finding a substring in a given string through "String" class - Method 1. 		
			result = "Method 1 \n"
								+ "-------- \n"
								+ "Input String : " + input_string + "\n"
								+ "From String  : " + from_string + "\n"
								+ "To String    : " + to_string + "\n"
								+ "Result       : ";
			
			result_list = getSubString(input_string, from_string, to_string);
			if(result_list.size()!=0) 
			{
				for (String sub_text : result_list) {
					result = result + sub_text + "\n";
				}
			}
			else
			{
				result = result + "No result found\n";
			}
			
			//Display the result to standard out
			System.out.println(result);

		} catch (IOException e) {
			System.err.println("Error on input value reading \n");
			e.printStackTrace();
		} 
	}
	

	/*
	 * Method is used to return all the substrings found in the given string respective to provided 
	 * "from_String" and "to_string""
	 */
	private static ArrayList<String> getSubString(String input_string, String from_string, String to_string) {
		int start_index = 0;
		int result_string_start_index = 0;
		int result_string_end_index = 0;
		ArrayList<String> result_list = new ArrayList<>();

		//Find the from_string one by one in given input_string. 
		while(input_string.indexOf(from_string, start_index)!=-1)
		{
			start_index = input_string.indexOf(from_string, start_index) + from_string.length();
			result_string_start_index = start_index;
			
			int end_index = result_string_start_index;
			
			//For each from_string find all the to_strings and collect all the subsequent substrings. 
			while(input_string.indexOf(to_string, end_index)!=-1)
			{
				result_string_end_index = input_string.indexOf(to_string, end_index);
				end_index = input_string.indexOf(to_string, end_index) + to_string.length();
				
				result_list.add(input_string.substring(result_string_start_index, result_string_end_index));
			}
		}
		return result_list;
	}

}
