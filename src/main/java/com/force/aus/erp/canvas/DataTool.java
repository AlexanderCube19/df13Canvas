package com.force.aus.erp.canvas;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

/**
 * simple class to build hibernate import script from export
 * 
 * @author tsellers
 *
 */
public class DataTool {

	private static final String FILE = "data.csv";
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		DataTool t = new DataTool();
		t.run();

	}

	private void run() {
		
		try {
			BufferedReader reader = new BufferedReader(new FileReader(new File(FILE)));
			String insertStatement = processFirstLine(reader.readLine());
			String line = "";
		
			while((line = reader.readLine()) != null) {
				System.out.println(processLine(line, insertStatement));
			}
			reader.close();
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
		
	}
	
	private String processFirstLine(String line) {
		
		StringBuilder sb = new StringBuilder();
		String[] headers = line.split(",");
		sb.append("insert into account (id,");
		for(int i=0 ; i<headers.length ; i++){
			sb.append(headers[i].replaceAll("\"", ""));
			if(i < headers.length-1) 
				sb.append(",");
		}
		
		sb.append(")");
		
		return sb.toString();
		
	}
	
	private String processLine(String line, String insertStmt) {
		
		StringBuilder sb =  new StringBuilder();
		
		sb.append(insertStmt);
		sb.append(" values (nextval('account_seq'),");
		String[] values = line.split(",");
		for(int i=0 ; i<values.length ; i++) {
			if(!values[i].equals("\"\""))
				sb.append(values[i].replaceAll("\"", "'"));
			else 
				sb.append("null");
			if(i<values.length-1)
				sb.append(",");
		}
		sb.append(")");
		return sb.toString();
		
	}
}
