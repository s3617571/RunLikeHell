import java.io.*;
import java.util.ArrayList;

public class UserData {
	ArrayList<User> users = new ArrayList<User>();
	File file = new File("data.txt");

	public String getName() {
		return users.get(0).getUserName();
	}

	public void register(User user) {
		try {
			FileWriter fileWriter = new FileWriter(file);
			BufferedWriter bufferWriter = new BufferedWriter(fileWriter);
			bufferWriter.write(user.getUserName()+" "+user.getPassword()+"\n");
			bufferWriter.close();
			fileWriter.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public boolean isLogin(String userName, String password) {
		InputStreamReader read;
		try {
			read = new InputStreamReader(new FileInputStream(file));
			BufferedReader bufferedReader = new BufferedReader(read);
			String lineT = null;
			while((lineT = bufferedReader.readLine()) != null) {
				String[] str = lineT.split(" ");
				User user = new User(str[0],str[1]);
				users.add(user);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		boolean flag = false;
		for (User user : users) {
			if (userName.equals(user.getUserName()) && password.equals(user.getPassword())) {
				flag = true;
				break;
			}
		}
		return flag;
	}
}