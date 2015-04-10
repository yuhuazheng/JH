package Algorithms;

public class VersionCompare {

	public static void main(String[] args){
		VersionCompare helper = new VersionCompare();
		String v1="1.0";
		String v2="1";
		System.out.println(helper.compareVersion(v1, v2));
	}
	
	public int compareVersion(String version1, String version2) {
		if(version1==null || version1.length()<1 || version2==null || version2.length()<1){
			return 0;
		}
		
		String delims = "[./z]";
		String[] num1 = version1.split(delims);
		String[] num2 = version2.split(delims);
		int v1=0;
		int v2=0;
		int count=0;
		for(int i=0; i<num1.length&&i<num2.length; i++){
			count++;
			v1=Integer.parseInt(num1[i]);
			v2=Integer.parseInt(num2[i]);
			if(v1>v2){
				return 1;
			}
			if(v1<v2){
				return -1;
			}
		}
		if(count<num1.length){
			for(int j=count; j<num1.length;j++){
				int temp = Integer.parseInt(num1[j]);
				if(temp>0){
					return 1;
				}
			}
			return 0;
		}
		if(count<num2.length){
			for(int j=count; j<num2.length;j++){
				int temp = Integer.parseInt(num2[j]);
				if(temp>0){
					return -1;
				}
			}
			return 0;
		}
		return 0;
	}
}
