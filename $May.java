package BC;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.event.Event;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.fxml.FXML;
import java.util.*;

public class $May extends Application{
	/*public static void main(String[] args) {
      launch(args);
   }*/
   Main obj=new Main();
   public void init(){
	//obj=new Main(); // declaring it inside init causes a null pointer exception, makng this declaration outside fixes it.
	
    System.out.println("Inside the init() method");
}



ArrayList<pair> changed_settings=new ArrayList<pair>();

@FXML private TextField res_x;

@FXML private TextField res_y;

@FXML private Button save_btn;

@FXML private RadioButton dof_on;
@FXML private RadioButton dof_off;

@FXML private RadioButton bloom_on;
@FXML private RadioButton bloom_off;

@Override
	public void start(Stage stage) throws Exception {
       Parent root = FXMLLoader.load(getClass().getResource("may.fxml"));
    
    
        Scene scene = new Scene(root, 300, 275);
    
        stage.setTitle("Testing....");
        stage.setScene(scene);
        stage.show();
    }
	public void res_x_handler()
	{
		String new_res=res_x.getText();
		System.out.println(new_res);
		if(changed_settings.add(new pair ("ResX",new_res)))
			System.out.println("Added successfully");
		else
			System.out.println("Not added");
		
		//System.out.println();
		
	}
	public void res_y_handler()
	{
		String new_res=res_y.getText();
		changed_settings.add(new pair("ResY",new_res));
	}
	public void save_btn_handler()
	{
		obj.readFile();
		System.out.println(changed_settings.size());
		System.out.println(changed_settings.isEmpty());
		if(obj==null)
			System.out.println("Obj is null");
		else
			System.out.println("Obj is NOT null");
		obj.changeFile(changed_settings);
		obj.writeFile();
		
	}
	public void dof_on_handler()
	{
		changed_settings.add(new pair("DepthOfField","true"));
	}
	public void dof_off_handler()
	{
		changed_settings.add(new pair("DepthOfField","false"));
	}
	public void bloom_on_handler()
	{
		changed_settings.add(new pair("Bloom","true"));
	}
	public void bloom_off_handler()
	{
		changed_settings.add(new pair("Bloom","false"));
	}
}