/*
* “aaaabbbb” → “a4b4” // encoding
* “a3b5” → “aaabbbbb” // decoding
*/
/*
Public String Encode(String str){
	if(str==null || str.length<1){
		return str;
	}
	StringBuilder res = new StringBuilder();
	char cur=str.Charat(0);
	int count=1;
	for(int i=1;i<str.length; i++){
		if(str.Charat(i)!=cur){
			res.append(cur);
			res.append(Interger.ToString(count);
			cur=str.Charat(i);
			count=1;
		}
		else{
			count++;
		}
	}
	return res.ToString();
}

Public String Decode(String str){
	if(str==null || str.length<1){
	return str;
	}
	StringBuilder res = new StringBuilder();
	char cur = str.Charat(0);
	int count=0;
	for(int i=1; i<str.length;i++){
		if(str.Charat(i)!=cur && str.Charat(i)>=’a’ && str.Charat(i)<=’z’){	
			for(int j=count; j>0;j--){
				res.append(cur);
			}
			cur=str.Charat(i);
			count=0;
		}
		else{
			count = count*10+Character.ToInterger(str.Charat(i));
		}
	}
	for(int j=count; j>0;j--){
		res.append(cur);
	}

	return res.ToString();
}
*/