package paket;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.control.TextField;

public class KontrolcuUygulama1 implements Initializable { // Kal?t?m yapt?k ! 
 
    @FXML
    private TextField txtPlaka; // 

    @FXML
    private ComboBox<String> cmbMarka;

    @FXML
    private ComboBox<String> cmbT?r;

    @FXML
    private ComboBox<String> cmbVitesT?r?;

    @FXML
    private ComboBox<String> cmbYak?tT?r?;

    @FXML
    private Spinner<Integer> spnModel;

    @FXML
    private ComboBox<String> cmbRenk;

    @FXML
    private ComboBox<String> cmbPlakaSe?imi;

    @FXML
    private TextField txtMarka;

    @FXML
    private TextField txtT?r;

    @FXML
    private TextField txtVitesT?r?;

    @FXML
    private TextField txtYak?tT?r?;

    @FXML
    private TextField txtModel;

    @FXML
    private TextField txtRenk;
    
    private ArrayList<Otomobil> otomobiller = new ArrayList<>();  // otomobiller dizisi! 

    @FXML
    void ara?Kay?t(ActionEvent event) {

    	String plaka = txtPlaka.getText(); // Plaka bilgisi
    	for (int i = 0; i < otomobiller.size(); i++) { // Ayn? plakal? ara? olamaz ! 
			if (plaka.equals(otomobiller.get(i).getPlaka())) {
				Alert hata = new Alert(AlertType.ERROR);
				hata.setTitle("Hata");
				hata.setHeaderText("Bu plakada zaten bir ara? kay?tl?...");
				hata.show();
				return; 
			}
		}
    	String marka = cmbMarka.getValue();
    	String t?r = cmbT?r.getValue();
    	String vitest?r? = cmbVitesT?r?.getValue();
    	String yakitt?r? = cmbYak?tT?r?.getValue();
    	int modelyili = spnModel.getValue();
    	String renk = cmbRenk.getValue();
    	
    	
    	Otomobil otomobil = new Otomobil(plaka, marka, t?r, vitest?r?, yakitt?r?, renk, modelyili);
    	otomobiller.add(otomobil);
    	
    	try {
			FileOutputStream fos = new FileOutputStream("ara?bilgiler.dat");
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(otomobiller); // otomobiller arraylisttinin i?erisine yazmas? gerek!!!
			fos.close();
			oos.close();
			Alert bilgilendirme = new Alert(AlertType.INFORMATION); 
			bilgilendirme.setTitle("Bilgi");
			bilgilendirme.setHeaderText(otomobil.getPlaka()+" plakal? ara? kay?t edildi.");
			bilgilendirme.show();
			cmbPlakaSe?imi.getItems().add(otomobil.getPlaka()); // Kay?t edildi?i anda combobx'?n i?erisine de d??mesini sa?lar!
		} catch (Exception e) { // ?ndeki filenotfound ekini kald?rd?m ! 
			e.printStackTrace();
		}
    }

    @FXML
    void ara?Sil(ActionEvent event) {
       
    	// remove(); komutu kullanarak silme i?lemi yap?lacak! 
    	int kay?tSil = cmbPlakaSe?imi.getSelectionModel().getSelectedIndex();
    	if(kay?tSil>=0) {
    		cmbPlakaSe?imi.getItems().remove(kay?tSil);
    		otomobiller.remove(kay?tSil);
    		
    		
    		try {
				FileOutputStream fos = new FileOutputStream("ara?bilgiler.dat");
				ObjectOutputStream oos = new ObjectOutputStream(fos);
				oos.writeObject(otomobiller);
				oos.close();
				fos.close();
				Alert silindi = new Alert(AlertType.WARNING);
				silindi.setTitle("Bilgi");
				silindi.setHeaderText("Bir ara? kay?ttan kald?r?ld?!");
				silindi.show();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    		
    	}
    
    }

    @FXML
    void plakaG?ster(ActionEvent event) {

    	int se?ilen = cmbPlakaSe?imi.getSelectionModel().getSelectedIndex();
    	txtMarka.setText(otomobiller.get(se?ilen).getMarka());
    	txtRenk.setText(otomobiller.get(se?ilen).getRenk());
    	txtT?r.setText(otomobiller.get(se?ilen).getT?r());
    	txtVitesT?r?.setText(otomobiller.get(se?ilen).getVitest?r?());
    	txtYak?tT?r?.setText(otomobiller.get(se?ilen).getYakitt?r?());
    	txtModel.setText(otomobiller.get(se?ilen).getModelyili() + " ");
    	
    }

	@Override
	public void initialize(URL location, ResourceBundle resources) { // kendili?inden ?al??an metod
		
 // mesela ?rnek 
   //Marka ve T?rlerin Combobox'lar?n?n i?erisini doldurdum.
		cmbMarka.getItems().add("Seat");
		   cmbT?r.getItems().add("Leon");
		   cmbT?r.getItems().add("Toledo");
		   cmbT?r.getItems().add("Ibiza");
		   
		cmbMarka.getItems().add("Ford");
		   cmbT?r.getItems().add("Mustang");
		   cmbT?r.getItems().add("Fiesta");
		   cmbT?r.getItems().add("Focus");
		
		cmbMarka.getItems().add("Volkswagen");
		  cmbT?r.getItems().add("Polo");
		  cmbT?r.getItems().add("Passat");
		  cmbT?r.getItems().add("Golf");
		  
	// Viteslerin T?rlerini girmek i?in Combobox'lar?n i?erisini doldurdum;
		cmbVitesT?r?.getItems().add("Otomatik");
		cmbVitesT?r?.getItems().add("Yar? Otomatik");
		cmbVitesT?r?.getItems().add("Manuel");
		
	// Yak?t T?r? doldurmas? i?in Comboboxlar?n i?erisini doldurdum.
		cmbYak?tT?r?.getItems().add("Dizel");
		cmbYak?tT?r?.getItems().add("Benzin");
		cmbYak?tT?r?.getItems().add("Benzin-LPG");
		
	// Renk Combobox'?n?n i?erisini doldurdum..
		cmbRenk.getItems().add("Siyah");
		cmbRenk.getItems().add("Beyaz");
		cmbRenk.getItems().add("K?rm?z?");
		cmbRenk.getItems().add("Mavi");
		cmbRenk.getItems().add("Kahverengi");
		cmbRenk.getItems().add("F?me");
		cmbRenk.getItems().add("Alt?n");
		
    // Spinner olarak model y?llar?n?n i?erisini doldurmam?z gerekmektedir.ort,min,max ve art?? miktar? 
		spnModel.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(1965, 2021, 2000, 1));
		
	try {
		FileInputStream fis = new FileInputStream("ara?bilgiler.dat");
		ObjectInputStream ois = new ObjectInputStream(fis); // nesneyi okumak i?in inputStreamleri kulland?k!
		otomobiller = (ArrayList<Otomobil>) ois.readObject();
		ois.close();
		
		for (int i = 0; i < otomobiller.size(); i++) {
			cmbPlakaSe?imi.getItems().add(otomobiller.get(i).getPlaka());
		}
		
	} catch (Exception e) {
		e.printStackTrace();
	}
				
		
	}

}
