#include <iostream>
#include <unordered_set>
#include <string>
#include <queue>
#include <map>

using std::string;
using std::unordered_set;
using std::queue;
using std::map;

class LadderLength {
public:

	//////////////////////
	//// version 1 with accessory function, not accepted by leetcode

	//int ladderLength(string start, string end, unordered_set<string> &dict) 
	//{
	//	if (start.compare(end) == 0) return 0;
	//	if (dict.find(start) == dict.end()) dict.insert(start);
	//	if (dict.find(end) == dict.end()) dict.insert(end);
	//	queue<string> q;
	//	q.push(start);
	//	dict.erase(start);
	//	map<string,int> dists;
	//	dists[start] = 0;

	//	while (q.size() != 0)
	//	{
	//		string word = q.front();
	//		q.pop();
	//		int length = dists[word];
	//		unordered_set<string> words = getWords(word);
	//		for ( auto it = words.begin(); it != words.end(); ++it )
	//		{
	//			if (dict.erase(*it) == 1)
	//			{
	//				if ((*it).compare(end) == 0)
	//				{
	//					std::cout << *it << " = " << length + 2 << std::endl;
	//					return length + 2; //if found end return length plus 2
	//				}
	//				dists[*it] = length+1;
	//				std::cout << *it << " = " << dists[*it] << std::endl;
	//				q.push(*it);
	//			}
	//		}
	//	}
	//	return 0;
	//};

	//unordered_set<string> getWords(const string & s)
	//{
	//	unordered_set<string> words;
	//	for (int i = 0; i < s.length(); ++i)
	//	{
	//		for (char c = 'a'; c < 'z'; ++c)
	//		{
	//			string t = s;
	//			t[i] = c;
	//			words.insert(t);
	//		}
	//	}
	//	return words;
	//};
	


	//////////////////////
	//// version 2 without accessory function, accepted by leetcode on 1/11/14

	int ladderLength(string start, string end, unordered_set<string> &dict) 
	{
		if (start.compare(end) == 0) return 0;
		if (dict.find(start) == dict.end()) dict.insert(start);
		if (dict.find(end) == dict.end()) dict.insert(end);
		queue<string> q;
		q.push(start);
		dict.erase(start);
		map<string,int> dists;
		dists[start] = 0;

		while (q.size() != 0)
		{
			string word = q.front();
			q.pop();
			int length = dists[word];

			for (int i = 0; i < word.length(); ++i)
			{
				for (char c = 'a'; c < 'z'; ++c)
				{
					string t = word;
					t[i] = c;
					if (dict.erase(t) == 1)
					{
						if (t.compare(end) == 0)
						{
							std::cout << t << " = " << length + 2 << std::endl;
							return length + 2; //if found end return length plus 2
						}
						dists[t] = length+1;
						std::cout << t << " = " << dists[t] << std::endl;
						q.push(t);
					}
				}
			}
		}
		return 0;
	};


	//int ladderLength(string start, string end, unordered_set<string> &dict) 
	//{
	//	unordered_set<string> added;
	//	queue<string> q;

	//	int ret = 0;
	//	int lev1 = 1, lev2 = 0;
	//	q.push(start);
	//	added.insert(start);

	//	while(!q.empty()) {
	//		string s = q.front(); q.pop();
	//		--lev1;

	//		for(int i = 0; i < s.length(); ++i) {
	//			for(int j = 0; j < 26; ++j) {
	//				string t = s;
	//				t[i] = 'a' + j;
	//				if(t != s) {
	//					if(t == end) return ret+2;
	//					if(dict.find(t) != dict.end() && added.find(t) == added.end()) 
	//					{
	//						std::cout << t << " = " << lev2 << std::endl;
	//						q.push(t);
	//						added.insert(t);
	//						++lev2;
	//					}
	//				}
	//			}
	//		}

	//		if(lev1 == 0) {
	//			++ret;
	//			lev1 = lev2;
	//			lev2 = 0;
	//		}
	//	}

	//	return 0;
	//}

};

int main()
{
	LadderLength s;
	string words[] = {"dose","ends","dine","jars","prow","soap","guns","hops","cray","hove","ella","hour","lens","jive","wiry","earl","mara","part","flue","putt","rory","bull","york","ruts","lily","vamp","bask","peer","boat","dens","lyre","jets","wide","rile","boos","down","path","onyx","mows","toke","soto","dork","nape","mans","loin","jots","male","sits","minn","sale","pets","hugo","woke","suds","rugs","vole","warp","mite","pews","lips","pals","nigh","sulk","vice","clod","iowa","gibe","shad","carl","huns","coot","sera","mils","rose","orly","ford","void","time","eloy","risk","veep","reps","dolt","hens","tray","melt","rung","rich","saga","lust","yews","rode","many","cods","rape","last","tile","nosy","take","nope","toni","bank","jock","jody","diss","nips","bake","lima","wore","kins","cult","hart","wuss","tale","sing","lake","bogy","wigs","kari","magi","bass","pent","tost","fops","bags","duns","will","tart","drug","gale","mold","disk","spay","hows","naps","puss","gina","kara","zorn","boll","cams","boas","rave","sets","lego","hays","judy","chap","live","bahs","ohio","nibs","cuts","pups","data","kate","rump","hews","mary","stow","fang","bolt","rues","mesh","mice","rise","rant","dune","jell","laws","jove","bode","sung","nils","vila","mode","hued","cell","fies","swat","wags","nate","wist","honk","goth","told","oise","wail","tels","sore","hunk","mate","luke","tore","bond","bast","vows","ripe","fond","benz","firs","zeds","wary","baas","wins","pair","tags","cost","woes","buns","lend","bops","code","eddy","siva","oops","toed","bale","hutu","jolt","rife","darn","tape","bold","cope","cake","wisp","vats","wave","hems","bill","cord","pert","type","kroc","ucla","albs","yoko","silt","pock","drub","puny","fads","mull","pray","mole","talc","east","slay","jamb","mill","dung","jack","lynx","nome","leos","lade","sana","tike","cali","toge","pled","mile","mass","leon","sloe","lube","kans","cory","burs","race","toss","mild","tops","maze","city","sadr","bays","poet","volt","laze","gold","zuni","shea","gags","fist","ping","pope","cora","yaks","cosy","foci","plan","colo","hume","yowl","craw","pied","toga","lobs","love","lode","duds","bled","juts","gabs","fink","rock","pant","wipe","pele","suez","nina","ring","okra","warm","lyle","gape","bead","lead","jane","oink","ware","zibo","inns","mope","hang","made","fobs","gamy","fort","peak","gill","dino","dina","tier"};
	std::unordered_set<std::string> dict;
	for (int i = 0; i < 336; ++i) dict.insert(words[i]);
	std::cout<< "length: " << s.ladderLength("nape", "mild", dict) << std::endl;
	std::cin.get();
	return 0;
}
