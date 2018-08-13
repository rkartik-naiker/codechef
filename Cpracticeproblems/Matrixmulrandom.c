#include<stdio.h>
#include<math.h>
#include <stdlib.h>

void main()
{
    int **a, **b, **c, *r, n, randomnum, *x1, *x2, *x3, flag=1;
    printf("Enter the order of matrix : ");
    scanf("%d",&n);
    a = (int **)malloc(n * sizeof(int));
    b = (int **)malloc(n * sizeof(int));
    c = (int **)malloc(n * sizeof(int));
    r = (int *)malloc(n * sizeof(int));
    x1 = (int *)malloc(n * sizeof(int));
    x2 = (int *)malloc(n * sizeof(int));
    x3 = (int *)malloc(n * sizeof(int));

    for(int i = 0; i<n; i++)
    {
        a[i] = (int *)malloc(n * sizeof(int));
        b[i] = (int *)malloc(n * sizeof(int));
        c[i] = (int *)malloc(n * sizeof(int));
    }

    printf("Enter elements for matrix A : \n");
    for(int i = 0; i<n; i++)
    {
        for(int j = 0; j<n; j++)
        {
            printf("Enter element A%d%d ",i+1,j+1);
            scanf("%d",&(a[i][j]));
        }
    }

    printf("Enter elements for matrix B : \n");
    for(int i = 0; i<n; i++)
    {
        for(int j = 0; j<n; j++)
        {
            printf("Enter element B%d%d ",i+1,j+1);
            scanf("%d",&b[i][j]);
        }
    }

    printf("Enter elements for matrix C : \n");
    for(int i = 0; i<n; i++)
    {
        for(int j = 0; j<n; j++)
        {
            printf("Enter element C%d%d ",i+1,j+1);
            scanf("%d",&c[i][j]);
        }
    }
    srand(time(0));
    for(int k = 0 ; k<10; k++)
    {

        printf("\nRandom numbers generated : \n");
        for(int i=0; i<n; i++)
        {
            randomnum = rand()%2;
            r[i] = randomnum;
            printf("%d\t", r[i]);
        }

        for(int i = 0; i<n; i++)
        {
            x1[i]=0;
            for(int j = 0; j<n; j++)
            {
                x1[i]+= b[i][j]*r[j];
            }
        }

        for(int i = 0; i<n; i++)
        {
            x2[i]=0;
            for(int j = 0; j<n; j++)
            {
                x2[i]+= a[i][j]*x1[j];
            }
        }

        for(int i = 0; i<n; i++)
        {
            x3[i]=0;
            for(int j = 0; j<n; j++)
            {
                x3[i]+= c[i][j]*r[j];
            }
        }

        for(int i = 0; i<n; i++)
        {
            if(x2[i]!=x3[i])
            {
                flag=0;
                break;
            }
        }
        if(flag)
            printf("\nAB = C\n");
        else
            printf("\nAB!=C\n");
    }
}
