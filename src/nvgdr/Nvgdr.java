/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nvgdr;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;
import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javax.swing.*;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
/**
 *
 * @author usuario
 */
public class Nvgdr {
    Thread thread = new Thread();
    String str;
    int n = 0 ;
    ActionListener al = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent ae) {
            str= add.getText();
            InputStream response;
            
    Platform.runLater(() -> {
        WebView webView = new WebView();
        WebEngine webEngine;
        jfxPanel.setScene(new Scene(webView));
        webEngine = webView.getEngine();
        webEngine.loadContent(str);
        
        });
    try {
                 
        Nvgdr obj = new Nvgdr();
        response = new URL(str).openStream();
        Scanner scanner = new Scanner(response);
        String responseBody = scanner.useDelimiter("\\A").next();
        System.out.println(responseBody.substring(responseBody.indexOf("<title>") + 7, responseBody.indexOf("</title>")));
        String responseBody2 = responseBody.substring(responseBody.indexOf("<title>") + 7, responseBody.indexOf("</title>"));
        tp.setTitleAt(0, responseBody2);
        response.close();
        } catch (IOException ex) {
            ex.printStackTrace();
       }
    }
 };
    JFrame jf = new JFrame();
    JFXPanel jfxPanel = new JFXPanel();
    JPanel pan = new JPanel();
    JTabbedPane tp = new JTabbedPane();
    JTextField add = new JTextField("",30);
    JButton bt = new JButton("Ir");
    public void NewClass(){
        jf.setLayout(new BorderLayout());
        jf.add(pan , BorderLayout.NORTH);
        jf.add(tp, BorderLayout.CENTER);
        tp.add(jfxPanel);
        pan.add(add);
        pan.add(bt);
        bt.addActionListener(al);
        jf.setVisible(true);
        jf.setDefaultCloseOperation(EXIT_ON_CLOSE);
        
       
    }
    public static void main(String args[]){
        new Nvgdr().NewClass();
    }
    public void run() throws MalformedURLException, IOException{
        InputStream response;
        do{
            try{
                response = new URL(str).openStream();
                Scanner scanner = new Scanner(response);
                String responseBody = scanner.useDelimiter("\\A").next();
                System.out.println(responseBody.substring(responseBody.indexOf("<title>") + 7, responseBody.indexOf("</title>")));
                String responseBody2 = responseBody.substring(responseBody.indexOf("<title>") + 7, responseBody.indexOf("</title>"));
                tp.setTitleAt(0, responseBody2);
                response.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }while(true);
    }
}
