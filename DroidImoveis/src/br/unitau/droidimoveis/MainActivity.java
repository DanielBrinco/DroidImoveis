package br.unitau.droidimoveis;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

/**
 * Classe principal da aplicação DroidImoveis, apresenta uma dashboard
 * contendo botões para acesso às diversas categorias de anúncios, bem
 * como aos dados relativos à aplicação e ao desenvolvedor;
 * 
 * @author Daniel Brinco
 *
 */
public class MainActivity extends Activity implements OnClickListener {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		// Configura click listeners e touch listeners para todos os botões:
		Button buttonCompra = (Button) findViewById(R.id.buttonCompra);
		buttonCompra.setOnClickListener(this);
		buttonCompra.setOnTouchListener(new ButtonHighlighter(buttonCompra));
		Button buttonVenda = (Button) findViewById(R.id.buttonVenda);
		buttonVenda.setOnClickListener(this);
		buttonVenda.setOnTouchListener(new ButtonHighlighter(buttonVenda));
		Button buttonAluguel = (Button) findViewById(R.id.buttonAluguel);
		buttonAluguel.setOnClickListener(this);
		buttonAluguel.setOnTouchListener(new ButtonHighlighter(buttonAluguel));
		Button buttonPermuta = (Button) findViewById(R.id.buttonPermuta);
		buttonPermuta.setOnClickListener(this);
		buttonPermuta.setOnTouchListener(new ButtonHighlighter(buttonPermuta));
		Button buttonSobre = (Button) findViewById(R.id.buttonSobre);
		buttonSobre.setOnClickListener(this);
		buttonSobre.setOnTouchListener(new ButtonHighlighter(buttonSobre));
		Button buttonDesenvolvedor = (Button) findViewById(R.id.buttonDesenvolvedor);
		buttonDesenvolvedor.setOnClickListener(this);
		buttonDesenvolvedor.setOnTouchListener(new ButtonHighlighter(buttonDesenvolvedor));
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	/**
	 * Carrega a tela referente à opção selecionada pelo usuário;
	 */
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.buttonSobre:
			Intent sobre = new Intent(this, About.class);
			startActivity(sobre);
			break;
		case R.id.buttonPermuta:
			Intent permuta = new Intent(this, Permuta.class);
			startActivity(permuta);
			break;
		case R.id.buttonAluguel:
			Intent aluguel = new Intent(this, Aluguel.class);
			startActivity(aluguel);
			break;
		case R.id.buttonVenda:
			Intent venda = new Intent(this, Venda.class);
			startActivity(venda);
			break;
		case R.id.buttonCompra:
			Intent compra = new Intent(this, Compra.class);
			startActivity(compra);
			break;
		case R.id.buttonDesenvolvedor:
			Intent desenv = new Intent(this, Desenvolvedor.class);
			startActivity(desenv);
			break;
		default:
			break;
		} // Fim do switch;
	} // Fim do método onClick;
} // Fim da classe MainActivity;
