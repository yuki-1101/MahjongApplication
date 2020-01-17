package model;

import java.util.ArrayList;
import java.util.List;


public class SelectedTileCheck {

	private List<String> roleName;
	private List<String> tehaiList;
	private List<String> tehaiImageList;
	private String tsumo;

	/*public SelectedTileCheck(List<String> tehaiList, List<String> tehaiImageList) {

		this.tehaiList = tehaiList;
		this.tehaiImageList = tehaiImageList;
	}*/


	public List<String> getTehaiList() {
		return this.tehaiImageList;
	}

	public List<String> getTehaiImageList() {
		return this.tehaiImageList;
	}

	public String getTsumo() {
		return this.tsumo;
	}

	public List<String> getRoleName(){
		return this.roleName;
	}

	public void setTehai(String tehai, String change) {

		//牌の交換が選択された場合は牌を入れ替える
		if(change != null) {

			this.changeTile(change, tehai);
			return;

		}

		if(this.tehaiList == null) {

			this.tehaiList = new ArrayList<String>();
			this.tehaiImageList = new ArrayList<String>();
			this.tehaiList.add(tehai);
			this.tehaiImageList.add(TehaiConverter.Conversion(tehai));

		} else if(this.tehaiList.size() < 4) {

			this.tehaiList.add(tehai);
			this.tehaiImageList.add(TehaiConverter.Conversion(tehai));

		} else if(this.tehaiList.size() < 13){
			boolean flag = true;
			for(int i = 0; i < this.tehaiList.size(); i++) {
				int count = 1;
				String name = this.tehaiList.get(i);
				for(int j = i + 1; j < this.tehaiList.size(); j++) {
					if(this.tehaiList.get(j).equals(name)) {
						count++;
					}
				}
				if((count == 4) && (name.equals(tehai))){
						flag=false;
						break;
				}
			}
			if(flag){
				this.tehaiList.add(tehai);
				this.tehaiImageList.add(TehaiConverter.Conversion(tehai));
			}

		} else if(this.tehaiList.size() == 13) {
			this.roleName = new ArrayList<String>();
			this.roleName = Role.roleCheck(tehaiList, tehai);
			this.tsumo = TehaiConverter.Conversion(tehai);
			System.out.println(this.roleName.get(0));
		}

	}

	private void changeTile(String change,String tehai) {
			int i = Integer.parseInt(change);
			this.tehaiList.set(i, tehai);
			this.tehaiImageList.set(i, TehaiConverter.Conversion(tehai));
	}
}
