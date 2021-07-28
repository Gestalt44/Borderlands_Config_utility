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

public class GUI_Controller extends Application{
	/*public static void main(String[] args) {
      launch(args);
   }*/
   file_Accessor obj=new file_Accessor();
   public void init(){
	//obj=new Main(); // declaring it inside init causes a null pointer exception, makng this declaration outside fixes it.
	
    System.out.println("Inside the init() method");
}



ArrayList<pair> changed_settings=new ArrayList<pair>();

// textfields
@FXML private TextField res_x;
@FXML private TextField res_y;
@FXML private TextField min_Shadow_Resolution;
@FXML private TextField max_Shadow_Resolution;
@FXML private TextField MaxWholeSceneDominantShadowResolution;


// DefaultPostProcess buttons
@FXML private Button save_btn;
@FXML private Button willow;
@FXML private Button scene;
@FXML private Button cine;
@FXML private Button ryan;

//skeletalMeshLodBias Buttons
@FXML private Button sk_highest;
@FXML private Button sk_high;
@FXML private Button sk_low;
@FXML private Button sk_lowest;

//ParticleLodBias buttons
@FXML private Button p_highest;
@FXML private Button p_high;
@FXML private Button p_low;
@FXML private Button p_lowest;

//DetailMode buttons
@FXML private Button detail_high;
@FXML private Button detail_low;
@FXML private Button detail_lowest;

// ShadowFilterQualityBias buttons
@FXML private Button shd_highest;
@FXML private Button shd_high;
@FXML private Button shd_low;
@FXML private Button shd_lowest;

// MaxAnisotropy buttons
@FXML private Button Aniso_highest;
@FXML private Button Aniso_high;
@FXML private Button Aniso_low;
@FXML private Button Aniso_lowest;

// All RadioButtons
@FXML private RadioButton dof_on;
@FXML private RadioButton dof_off;

@FXML private RadioButton bloom_on;
@FXML private RadioButton bloom_off;

@FXML private RadioButton d_decal_on;
@FXML private RadioButton d_decal_off;

@FXML private RadioButton s_decal_on;
@FXML private RadioButton s_decal_off;

@FXML private RadioButton d_shadow_on;
@FXML private RadioButton d_shadow_off;

@FXML private RadioButton d_light_on;
@FXML private RadioButton d_light_off;

@FXML private RadioButton motion_blur_on;
@FXML private RadioButton motion_blur_off;

@FXML private RadioButton a_occulsion_on;
@FXML private RadioButton a_occulsion_off;

@FXML private RadioButton distortion_on;
@FXML private RadioButton distortion_off;

@FXML private RadioButton FXAA_on;
@FXML private RadioButton FXAA_off;



@Override
	public void start(Stage stage) throws Exception {
       Parent root = FXMLLoader.load(getClass().getResource("may.fxml"));
    
    
        Scene scene = new Scene(root, 800,600);
    
        stage.setTitle("Welcome to the Borderlands 2 Configuration Utility.");
        stage.setScene(scene);
        stage.show();
    }
	public void res_x_handler()
	{
		String new_res=res_x.getText();
		changed_settings.add(new pair ("ResX",new_res));	
	}
	public void res_y_handler()
	{
		String new_res=res_y.getText();
		changed_settings.add(new pair("ResY",new_res));
	}
	
	public void min_Shadow_Resolution_handler(){
		changed_settings.add(new pair("MinShadowResolution",min_Shadow_Resolution.getText()));
	}
	
	public void max_Shadow_Resolution_handler(){
		changed_settings.add(new pair("MaxShadowResolution",max_Shadow_Resolution.getText()));
	}
	
	public void MaxWholeSceneDominantShadowResolution_handler(){
		changed_settings.add(new pair("MaxWholeSceneDominantShadowResolution",MaxWholeSceneDominantShadowResolution.getText()));
	}
	public void save_btn_handler()
	{
		obj.readFile();
		obj.changeFile(changed_settings);
		obj.writeFile();
		Stage stage = (Stage)save_btn.getScene().getWindow();
        stage.close(); 
	}
	
	public void willow_Handler(){
		System.out.println("In willow handler");
		changed_settings.add(new pair("DefaultPostProcessName","WillowEngineMaterials.WillowScenePostProcess"));
	}
	
	public void scene_Handler(){
		changed_settings.add(new pair("DefaultPostProcessName","WillowEngineMaterials.ScenePostProcess"));
	}
	
	public void cine_Handler(){
		changed_settings.add(new pair("DefaultPostProcessName","WillowEngineMaterials.CinematicScenePostProcess"));
	}
	
	public void ryan_Handler(){
		changed_settings.add(new pair("DefaultPostProcessName","WillowEngineMaterials.RyanScenePostProcess"));
	}
	
	//  SkeletalMeshLODBias Handling
	public void sk_highest_handler(){
		changed_settings.add(new pair("SkeletalMeshLODBias","-1"));
	}
	public void sk_high_handler(){
		changed_settings.add(new pair("SkeletalMeshLODBias","-0"));
	}
	public void sk_low_handler(){
		changed_settings.add(new pair("SkeletalMeshLODBias","1"));
	}
	public void sk_lowest_handler(){
		changed_settings.add(new pair("SkeletalMeshLODBias","2"));
	}
	
	
	
	// Particle_lod_BIAS handling
	public void p_highest_handler(){
	changed_settings.add(new pair("ParticleLODBias","-1"));
	}
	public void p_high_handler(){
	changed_settings.add(new pair("ParticleLODBias","-0"));
	}
	public void p_low_handler(){
	changed_settings.add(new pair("ParticleLODBias","1"));
	}
	public void p_lowest_handler(){
	changed_settings.add(new pair("ParticleLODBias","2"));
	}
	
	//Detail Mode handling
	public void detail_highest_handler(){
	changed_settings.add(new pair("DetailMode","2"));
	}
	public void detail_low_handler(){
	changed_settings.add(new pair("DetailMode","1"));
	}
	public void detail_lowest_handler(){
	changed_settings.add(new pair("DetailMode","0"));
	}
	
	// ShadowFilterQualityBias handling
	public void shd_highest_handler(){
		changed_settings.add(new pair("ShadowFilterQualityBias","-1"));
	}
	public void shd_high_handler(){
		changed_settings.add(new pair("ShadowFilterQualityBias","0"));
	}
    public void shd_low_handler(){
		changed_settings.add(new pair("ShadowFilterQualityBias","1"));
	}	
	public void shd_lowest_handler(){
		changed_settings.add(new pair("ShadowFilterQualityBias","2"));
	}
	
	// Anisotropy handling
	public void Aniso_lowest_handler(){
		changed_settings.add(new pair("MaxAnisotropy","2"));
	}
	public void Aniso_low_handler(){
		changed_settings.add(new pair("MaxAnisotropy","4"));
	}
	public void Aniso_high_handler(){
		changed_settings.add(new pair("MaxAnisotropy","8"));
	}
	public void Aniso_highest_handler(){
		changed_settings.add(new pair("MaxAnisotropy","16"));
	}
	
	
	
	
	
	// ON/OFF Radiobuttons handling
	public void dof_on_handler()
	{
		changed_settings.add(new pair("DepthOfField","true"));
	}
	public void dof_off_handler()
	{
		changed_settings.add(new pair("DepthOfField","false"));
	}
	
	//bloom
	public void bloom_on_handler()
	{
		changed_settings.add(new pair("Bloom","true"));
	}
	public void bloom_off_handler()
	{
		changed_settings.add(new pair("Bloom","false"));
	}
	
	// Dynamic decals
	public void d_decal_on_handler()
	{
		changed_settings.add(new pair("DynamicDecals","True"));
	}
	public void d_decal_off_handler()
	{
		changed_settings.add(new pair("DynamicDecals","False"));
	}
	
	// Static decals
	public void s_decal_on_handler()
	{
		changed_settings.add(new pair("StaticDecals","True"));
	}
	public void s_decal_off_handler()
	{
		changed_settings.add(new pair("StaticDecals","False"));
	}
	
	// Dybamic shadows 
	public void d_shadow_on_handler()
	{
		changed_settings.add(new pair("DynamicShadows","True"));
	}
	public void d_shadow_off_handler()
	{
		changed_settings.add(new pair("DynamicShadows","False"));
	}
	
	// Dynamic lights
	public void d_light_on_handler()
	{
		changed_settings.add(new pair("DynamicLights","True"));
	}
	public void d_light_off_handler()
	{
		changed_settings.add(new pair("DynamicLights","False"));
	}
	
	//motion_blur
	public void motion_blur_on_handler()
	{
		changed_settings.add(new pair("MotionBlur","True"));
	}
	public void motion_blur_off_handler()
	{
		changed_settings.add(new pair("MotionBlur","False"));
	}
	
	// Ambient occulsion
	public void a_occulsion_on_handler()
	{
		changed_settings.add(new pair("AmbientOcclusion","True"));
	}
	public void a_occulsion_off_handler()
	{
		changed_settings.add(new pair("AmbientOcclusion","False"));
	}
	
	// Distortion
	public void distortion_on_handler()
	{
		changed_settings.add(new pair("Distortion","True"));
	}
	public void distortion_off_handler()
	{
		changed_settings.add(new pair("Distortion","False"));
	}
	
	// FXAA
	public void FXAA_on_handler()
	{
		changed_settings.add(new pair("FXAA","True"));
	}
	public void FXAA_off_handler()
	{
		changed_settings.add(new pair("FXAA","False"));
	}
	
	
}