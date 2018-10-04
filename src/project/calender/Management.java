package project.calender;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

public class Management {

	public void saveFile(String date, String plan) {
		OutputStreamWriter out = null;
		BufferedWriter bufOut = null;

		try {
			out = new FileWriter("C:\\yoon\\Study\\Programming\\java_workspace\\calendar\\save.txt", true);
			bufOut = new BufferedWriter(out);
			bufOut.write(date + ",");
			bufOut.write(plan);

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (bufOut != null)
					bufOut.close();
				if (out != null)
					out.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public HashMap<Date, String> loadFile() {

		HashMap<Date, String> list = new HashMap<>();
		File file = new File("C:\\yoon\\Study\\Programming\\java_workspace\\calendar\\save.txt");
		InputStreamReader in = null;
		BufferedReader bufIn = null;

		try {
			if (file.exists()) {
				in = new FileReader("C:\\yoon\\Study\\Programming\\java_workspace\\calendar\\save.txt");
				bufIn = new BufferedReader(in);
				while (true) {
					String line = bufIn.readLine();
					if (line==null) break;
					String[] splitLine = line.split(",");
					String strDate = splitLine[0];
					String plan = splitLine[1];

					Date date = new SimpleDateFormat("yyyy-MM-dd").parse(strDate);

					list.put(date, plan);
				}
				
				
			} else {
				return null;
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} catch (IOException e2) {
			e2.printStackTrace();
		} catch (ParseException e3) {
			e3.printStackTrace();
		} finally {
			try {
				if (bufIn != null)
					bufIn.close();
				if (in != null)
					in.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return list;

	}

}
