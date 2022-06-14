package LEGENDARY.STREAMER.YT.UTIL;

import android.app.Activity;
import android.app.*;
import android.os.*;
import android.view.*;
import android.view.View.*;
import android.widget.*;
import android.content.*;
import android.content.res.*;
import android.graphics.*;
import android.graphics.drawable.*;
import android.media.*;
import android.net.*;
import android.text.*;
import android.text.style.*;
import android.util.*;
import android.webkit.*;
import android.animation.*;
import android.view.animation.*;
import java.util.*;
import java.util.regex.*;
import java.text.*;
import org.json.*;
import android.widget.TextView;
import android.widget.ListView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.DialogFragment;


public class MainActivity extends  Activity { 
	
	
	private String TITLE = "";
	private String DESCRIPTION = "";
	private String thumbDF = "";
	private String thumbMD = "";
	private String thumbHG = "";
	private String thumbSD = "";
	
	private TextView textview1;
	private TextView textview3;
	private TextView textview2;
	private TextView textview4;
	private TextView Thumbnail;
	private ListView listview1;
	
	private RequestNetwork REQ;
	private RequestNetwork.RequestListener _REQ_request_listener;
	@Override
	protected void onCreate(Bundle _savedInstanceState) {
		super.onCreate(_savedInstanceState);
		setContentView(R.layout.main);
		initialize(_savedInstanceState);
		initializeLogic();
	}
	
	private void initialize(Bundle _savedInstanceState) {
		
		textview1 = (TextView) findViewById(R.id.textview1);
		textview3 = (TextView) findViewById(R.id.textview3);
		textview2 = (TextView) findViewById(R.id.textview2);
		textview4 = (TextView) findViewById(R.id.textview4);
		Thumbnail = (TextView) findViewById(R.id.Thumbnail);
		listview1 = (ListView) findViewById(R.id.listview1);
		REQ = new RequestNetwork(this);
		
		_REQ_request_listener = new RequestNetwork.RequestListener() {
			@Override
			public void onResponse(String _param1, String _param2, HashMap<String, Object> _param3) {
				final String _tag = _param1;
				final String _response = _param2;
				final HashMap<String, Object> _responseHeaders = _param3;
				LegendaryStreamerYTUTIL.Response(_response);
				TITLE = LegendaryStreamerYTUTIL.getTitle;
				DESCRIPTION = LegendaryStreamerYTUTIL.getDescription;
				thumbDF = LegendaryStreamerYTUTIL.getThumbnailDF;
				thumbMD = LegendaryStreamerYTUTIL.getThumbnailMD;
				thumbHG = LegendaryStreamerYTUTIL.getThumbnailHG;
				thumbSD = LegendaryStreamerYTUTIL.getThumbnailSD;
				textview1.setText(TITLE);
				textview2.setText(DESCRIPTION);
				Thumbnail.setText("DEFAULT = ".concat(thumbDF.concat("\nMEDIUM = ".concat(thumbMD.concat("\nHIGH = ".concat(thumbHG.concat("\nSTANDARD = ".concat(thumbSD))))))));
				listview1.setAdapter(new ArrayAdapter<String>(getBaseContext(), android.R.layout.simple_list_item_1, _tags_list()));
				((BaseAdapter)listview1.getAdapter()).notifyDataSetChanged();
			}
			
			@Override
			public void onErrorResponse(String _param1, String _param2) {
				final String _tag = _param1;
				final String _message = _param2;
				
			}
		};
	}
	
	private void initializeLogic() {
		textview1.setText("//TITLE WILL APPEAR HERE");
		textview2.setText("//DESCRIPTION WILL APPEAR HERE");
		Thumbnail.setText("//THUMBNAIL URL WILL APPEAR HERE");
		REQ.startRequestNetwork(RequestNetworkController.GET, LegendaryStreamerYTUTIL.getURL("https://youtu.be/et32QbmeCVU"), "", _REQ_request_listener);
	}
	
	@Override
	protected void onActivityResult(int _requestCode, int _resultCode, Intent _data) {
		
		super.onActivityResult(_requestCode, _resultCode, _data);
		
		switch (_requestCode) {
			
			default:
			break;
		}
	}
	
	public void _INSTRUCTIONS_TO_USE () {
		/*

LegendaryStreamerYTUTIL.getURL(String)

//returns String Value (url for req net)
LegendaryStreamerYTUTIL.Response(String);

//adding on OnResponse
LegendaryStreamerYTUTIL.getTitle

//returns string value
LegendaryStreamerYTUTIL.getDescription

//returns string value
LegendaryStreamerYTUTIL.getThumbnailDF --> DEFAULT

LegendaryStreamerYTUTIL.getThumbnailMD --> MEDIUM

LegendaryStreamerYTUTIL.getThumbnailHG --> HIGH

LegendaryStreamerYTUTIL.getThumbnailSD --> STANDARD

//return string value (IMG-url)
LegendaryStreamerYTUTIL.tags_list

//returns ListString (ArrayList)

*/
	}
	
	
	public ArrayList<String> _tags_list () {
		return LegendaryStreamerYTUTIL.tags_list;
	}
	
	
	@Deprecated
	public void showMessage(String _s) {
		Toast.makeText(getApplicationContext(), _s, Toast.LENGTH_SHORT).show();
	}
	
	@Deprecated
	public int getLocationX(View _v) {
		int _location[] = new int[2];
		_v.getLocationInWindow(_location);
		return _location[0];
	}
	
	@Deprecated
	public int getLocationY(View _v) {
		int _location[] = new int[2];
		_v.getLocationInWindow(_location);
		return _location[1];
	}
	
	@Deprecated
	public int getRandom(int _min, int _max) {
		Random random = new Random();
		return random.nextInt(_max - _min + 1) + _min;
	}
	
	@Deprecated
	public ArrayList<Double> getCheckedItemPositionsToArray(ListView _list) {
		ArrayList<Double> _result = new ArrayList<Double>();
		SparseBooleanArray _arr = _list.getCheckedItemPositions();
		for (int _iIdx = 0; _iIdx < _arr.size(); _iIdx++) {
			if (_arr.valueAt(_iIdx))
			_result.add((double)_arr.keyAt(_iIdx));
		}
		return _result;
	}
	
	@Deprecated
	public float getDip(int _input){
		return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, _input, getResources().getDisplayMetrics());
	}
	
	@Deprecated
	public int getDisplayWidthPixels(){
		return getResources().getDisplayMetrics().widthPixels;
	}
	
	@Deprecated
	public int getDisplayHeightPixels(){
		return getResources().getDisplayMetrics().heightPixels;
	}
	
}