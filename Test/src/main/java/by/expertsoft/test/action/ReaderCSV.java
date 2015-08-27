package by.expertsoft.test.action;

import java.io.BufferedReader;
import java.io.FileReader;

import by.expertsoft.test.DAO.UsersConvert;
import by.expertsoft.test.DAOImpl.UsersConvertImpl;
import by.expertsoft.test.entity.User;
import by.expertsoft.test.util.Factory;

public class ReaderCSV {
	
	private BufferedReader reader = null;
	private String separator = ",";
	private User user = new User();
	private UsersConvert userConv = new UsersConvertImpl();
	
	
	public void convertToBD(String title){
		
		try{
			
			reader = new BufferedReader(new FileReader(title));
			
			String [] values;
			while(reader.ready()){
				
				values = reader.readLine().split(separator);

				user.setName(values[0]);
				user.setSurname(values[1]);
				user.setLogin(values[2]);
				user.setEmail(values[3]);
				user.setPhoneNumb(Integer.parseInt(values[4]));
				
				Factory.getInstance().getUserConvert().convUsers(user);
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}
	
}
