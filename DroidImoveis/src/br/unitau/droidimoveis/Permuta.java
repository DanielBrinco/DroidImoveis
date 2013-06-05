package br.unitau.droidimoveis;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class Permuta extends Activity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.permuta);
		
		try {
			// Create RSS reader
			RssReader rssReader = new RssReader("http://www.droidimoveis.vv.si/permuta.xml");
			// Get a ListView from main view
			ListView itcItems = (ListView) findViewById(R.id.listMainView);
			
			// Create a list adapter
			ArrayAdapter<RssItem> adapter = new ArrayAdapter<RssItem>(this,android.R.layout.simple_list_item_1, rssReader.getItems());
			// Set list adapter for the ListView
			itcItems.setAdapter(adapter);
			
			// Set list view item click listener
			itcItems.setOnItemClickListener(new ListListener(rssReader.getItems(), this));
			
		} catch (Exception e) {
			Toast.makeText(getApplicationContext(), "Erro de conexão.\nVerifique acesso à Internet.",
					Toast.LENGTH_LONG).show();
			Log.e("DroidImoveis", e.getMessage());
		}
	} // Fim do método onCreate;
} // Fim da classe Permuta;
