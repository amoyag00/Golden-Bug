/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package goldenbug;

import java.awt.event.ActionEvent;
import java.util.Map;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author alex
 */
public class CustomTextfield extends JTextField {
    private JTextField letra;
    private Map<Character,Character> map;
    
    public void setTraduccionText(String text){
        this.letra.setText(text);
    }
    public CustomTextfield(JTextField traduccion, Map<Character,Character> map){
        this.letra=traduccion;
        this.map=map;
    }
    
    public void updateMap(){
        char letra='*';
        if(!this.getText().isEmpty()){
            letra=this.getText().charAt(0);
        }
        this.map.put(this.letra.getText().charAt(0),letra);
        
    }
}
