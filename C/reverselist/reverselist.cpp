// reverselist.cpp : Defines the entry point for the console application.
//

#include "stdafx.h"


int _tmain(int argc, _TCHAR* argv[])
{

	node head;


	return 0;
}


void reverse (node head)
{
	if(head==0)
		return;
	if(head->next==0)
		return;
	if(head->next==tail)
	{
		head->next = 0;
		tail->next = head;
	}
	else
	{
		node* pre = head;
		node* cur = head->next;
		node* curnext = cur->next;
		head->next = 0;
		cur-> next = head;

		for(; curnext!=0; )
		{
			cur->next = pre;
			pre = cur;
			cur = curnext;
			curnext = curnext->next;
		}

		curnext->next = cur;
	}
}


class node
{
	node next;

}
