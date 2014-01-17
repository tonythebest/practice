#include <string>
#include <iostream>
#include "ValidPalindrome1.cpp"

using std::string;

class Solution2 {
public:
    bool isPalindrome(string s) {
        if (s.length() == 0) return true;
        int i = 0;
        int j = s.length() - 1;
        while (i < j)
        {
            if (s[i] >= 'A' && s[i] <= 'Z')
            {
                s[i] = s[i] + 'a' - 'A';
                if (s[j] >= 'A' && s[j] <= 'Z')
                {
                    s[j] = s[j] + 'a' - 'A';
                    if (s[i] != s[j]) return false;
                    ++i;
                    --j;
                }
                else if (s[j] >= 'a' && s[j] <= 'z' || s[j] >= '0' && s[j] <= '9')
                {
                    if (s[i] != s[j]) return false;
                    ++i;
                    --j;
                }
                else
                {
                    --j;
                }
            }
            else if (s[i] >= 'a' && s[i] <= 'z' || s[i] >= '0' && s[i] <= '9')
            {
                if (s[j] >= 'A' && s[j] <= 'Z')
                {
                    s[j] = s[j] + 'a' - 'A';
                    if (s[i] != s[j]) return false;
                    ++i;
                    --j;
                }
                else if (s[j] >= 'a' && s[j] <= 'z' || s[j] >= '0' && s[j] <= '9')
                {
                    if (s[i] != s[j]) return false;
                    ++i;
                    --j;
                }
                else
                {
                    --j;
                }
            }
            else
            {
                ++i;
            }
        }
        return true;
    }
};


int main()
{
	string s = "ads";
	std::cout<< s << std::endl;

	Solution1 obj1;
	if (obj1.isPalindrome(s))
	{
		std::cout<< "true" << std::endl;
	}
	else
	{
		std::cout<< "false" << std::endl;
	}

	Solution2 obj2;
	if (obj2.isPalindrome(s))
	{
		std::cout<< "true" << std::endl;
	}
	else
	{
		std::cout<< "false" << std::endl;
	}


	//std::cout<< obj.isPalindrome(s) << std::endl;
	std::cin.get();
	return 0;
}

