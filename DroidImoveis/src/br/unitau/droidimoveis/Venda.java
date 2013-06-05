package br.unitau.droidimoveis;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class Venda extends Activity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.venda);
		
		try {
			// Cria RSS reader:
			RssReader rssReader = new RssReader("http://www.droidimoveis.vv.si/venda.xml");
			
			// Obtém a ListView:
			ListView itcItems = (ListView) findViewById(R.id.listMainView);
			
			// Cria um list adapter:
			ArrayAdapter<RssItem> adapter = new ArrayAdapter<RssItem>(this,android.R.layout.simple_list_item_1, rssReader.getItems());
			
			// Define o list adapter para a ListView:
			itcItems.setAdapter(adapter);
			
			// Define o click listener para os itens da ListView:
			itcItems.setOnItemClickListener(new ListListener(rssReader.getItems(), this));
			
		} catch (Exception e) {
			Toast.makeText(getApplicationContext(), "Erro de conexão.\nVerifique acesso à Internet.",
					Toast.LENGTH_LONG).show();
			Log.e("DroidImoveis", e.getMessage());
		} // Fim do try/catch;
	} // Fim do método onCreate;
} // Fim da classe Venda;