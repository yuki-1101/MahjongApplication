package model;

import java.util.ArrayList;
import java.util.List;

public class SelectedTileProcess {

	private String tehai;

	public String getTehai() {
		return tehai;
	}

	public void setTehai(String tehai, String change, List<String> instance) {
		if(change == null){

			if(instance != null) {

				if(instance.size() < 13) {
					instance.add(tehai);
					this.tehai = tehai;
				}
			} else {
				instance = new ArrayList<String>();
				instance.add(tehai);
				this.tehai = tehai;
			}
		} else {
			int i = Integer.parseInt(change);
			instance.set(i, tehai);
			this.tehai = tehai;
		}
	}

}