#include<stdio.h>

class CPrefixSorting
{
public:
	CPreficSorting()
	{
		m_nCakeCnt = 0;
		m_nmaxSwap = 0;
	}

	void run(int* pCakeArray, int nCakeCnt)
	{
		Init(pCakeArray, nCakeCnt);

		m_nSearch = 0;
		Search(0);
	}

	void Output()
	{
		for(int i = 0; i < m_nMaxSwap; i++)
			printf("%d", m_arrSwap[i]);
		printf("\n |Search Times | : %d\n", m_nSearch);
		printf("Total swap times = %d\n", m_nMaxSwap);
	}
private:

	void Init(int* pCakeArray, int nCakeCnt)
	{
		
	}
	int* m_CakeArray;
	int m_nCakeCnt;
	int m_nMaxSwap;
	int* m_SwapArray;
	int* m_ReverseCakeArray;
	int* m_ReverseCakeArraySwap;
	int m_search;
}
