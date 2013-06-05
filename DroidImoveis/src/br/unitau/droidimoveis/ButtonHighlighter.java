package br.unitau.droidimoveis;

import android.graphics.Color;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.Button;

/**
 * Classe que permite a adição do efeito highlight durante o toque em um botão;
 * 
 * @author Daniel Brinco
 *
 */
public class ButtonHighlighter implements OnTouchListener {

	final Button button;

	public ButtonHighlighter(final Button button) {
		super();
		this.button = button;
	} // Fim do construtor;

	/**
	 * Altera a cor de background do botão durante o efeito touch;
	 */
	public boolean onTouch(final View view, final MotionEvent motionEvent) {
		if (motionEvent.getAction() == MotionEvent.ACTION_DOWN) {
			// Cor do efeito highlight:
			button.setBackgroundColor(Color.rgb(255, 215, 0));
			//button.setColorFilter(Color.argb(155, 185, 185, 185));
		} else if (motionEvent.getAction() == MotionEvent.ACTION_UP) {
			button.setBackgroundColor(Color.rgb(255, 0, 0));
		} // Fim do if/else;
		
		return false;
	} // Fim do método onTouch;
} // Fim da classe ButtonHighlighter;


