#include <string>
#include <iostream>

using std::string;

class Solution1 {
public:
    bool isPalindrome(string s) {
        if (s.length() == 0) return true;
        int i = 0;
        while (i < s.length())
        {
            if (s[i] >= 'A' && s[i] <= 'Z')
            {
                s[i] = s[i] + 'a' - 'A';
                ++i;
            }
            else if (s[i] >= 'a' && s[i] <= 'z' || s[i] >= '0' && s[i] <= '9')
            {
                ++i;
            }
            else
            {
                s.erase(i,1);
            }
        }
        i = 0;
        int j = s.length()-1;
        while (i < j)
        {
            if (s[i] == s[j])
            {
                ++i;
                --j;
            }
            else
            {
                return false;
            }
        }
        return true;
    }
};
