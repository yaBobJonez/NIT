package Components;

import Technical.Component;

import javax.imageio.ImageIO;
import javax.swing.*;

import General.ActionEvent;
import General.EventCode;
import General.MouseEvent;

import java.awt.*;
import java.io.IOException;
import java.net.URL;

public class Button extends Component {
	private JButton value;
	public Button(String text, int x, int y, int w, int h){
		this.value = new JButton(text);
		this.value.setSize(w, h);
		this.value.setLocation(x, y);
	}
	public Button(String text){ this(text, 0, 0, 100, 50); }
	public Button(){ this("", 0, 0, 100, 50); }
	@Override
	public JButton getRawValue(){
		return this.value;
	}
	public void setIcon(String url, int w, int h) throws IOException {
		this.value.setIcon(new ImageIcon(ImageIO.read(new URL(url)).getScaledInstance(w, h, Image.SCALE_FAST)));
	} public void setIcon(String url) throws IOException {
		this.setIcon(url, this.value.getWidth()-40, this.value.getHeight()-20);
	} public void removeIcon(){
		if(this.value.getIcon() != null) this.value.setIcon(null);
	}
	public void setOn(MouseEvent action, EventCode code) {
		this.value.addMouseListener(action.getEvent(action, code));
	} public void setOn(ActionEvent action, EventCode code) {
		this.value.addActionListener(action.getEvent(action, code));
	}
	public void setText(String text){
		this.value.setText(text);
	} public String getText(){
		return this.value.getText();
	}
}