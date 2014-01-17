/**
* Definition for binary tree
* struct TreeNode {
*     int val;
*     TreeNode *left;
*     TreeNode *right;
*     TreeNode(int x) : val(x), left(NULL), right(NULL) {}
* };
*/
#include <climits>
#include <cstdlib>

struct TreeNode 
{
	int val;
	TreeNode *left;
	TreeNode *right;
	TreeNode(int x) : val(x), left(NULL), right(NULL) {}
};

///////////////
// returned right away if false, so faster
class ValidateBinarySearchTree2 {
public:
	bool isValidBST(TreeNode *root) {
		int prev = INT_MIN;
		if (root == NULL) return true;
		bool b = true;
		isValid(root, prev, b);
		return b;
	}
	void isValid(TreeNode *root, int & prev, bool & b)
	{
		if (b == false) return;
		if (root->left != NULL) isValid(root->left, prev, b);
		if (prev >= root->val) 
		{
			b = false;
			return;
		}
		else
		{
			prev = root->val;
		}
		if (root->right != NULL) isValid(root->right, prev, b);
	}
};

///////////////
// did not return right away if false, so slower
class ValidateBinarySearchTree1 {
public:
    bool isValidBST(TreeNode *root) {
        int prev = INT_MIN;
        if (root == NULL) return true;
        bool b = true;
        isValid(root, prev, b);
        return b;
    }
    void isValid(TreeNode *root, int & prev, bool & b)
    {
        if (root->left != NULL) isValid(root->left, prev, b);
        if (prev >= root->val) 
        {
            b = false;
        }
        else
        {
            prev = root->val;
        }
        if (root->right != NULL) isValid(root->right, prev, b);
    }
};