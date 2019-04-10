Greg Murashige - HyperProof

Please choose Tools > Preferences and disable all autocorrect features.

/*

    http://www.server.com/folder1/my%20doc.docx   <-- output

    http://www.server.com/folder1/my doc.docx   <--- input

*/
	//ab c {'a','b',' ','c'}

	//1) count spaces in url to help determine size of encodedUrl
  //2) could also use list
char[] encodeUrl(char[] url){

	if (url.length == 0) return new char[]{};
	//1)
	int spaceCount = 0;
	for (char c : url){
		if (c == ' '){
			spaceCount++;
		}
	}

	char[] encodedUrl = new char[url.length + (spaceCount*2)]; //2)
	int j = 0;

		for (int i = 0; i < url.length; i++){
			if (url[i] == ' '){
				encodedUrl[j] = '%';
				encodedUrl[j+1] = '2';
				encodedUrl[j+2] = '0';
				j += 3;
			}else{
        encodedUrl[j] = url[i];
			  j++;
			}

    }

		return encodedUrl;
}
