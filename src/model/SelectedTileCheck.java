package model;

import java.util.ArrayList;
import java.util.List;

public class SelectedTileCheck {

	private List<String> tehaiList;

	public List<String> getTehai() {
		return tehaiList;
	}

	public void setTehai(String tehai, String change, List<String> instance) {
		if(change == null){

			if(instance != null) {

				if(instance.size() < 13) {
					instance.add(tehai);
					this.tehaiList = instance;
				}
			} else {
				instance = new ArrayList<String>();
				instance.add(tehai);
				this.tehaiList = instance;
				int y = 3;
			}
		} else {
			int i = Integer.parseInt(change);
			instance.set(i, tehai);
			this.tehaiList = instance;
		}
	}
}
