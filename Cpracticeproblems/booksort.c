#include<stdio.h>
#include<string.h>
struct book
{
    char bookName[50];
    char authorName[50];
    int edition;
    int isbn;
    int price;
    char publication[50];
    int year;
};

void swap(struct book* a, struct book* b)
{
    struct book t = *a;
    *a = *b;
    *b = t;
}

int partition (struct book *bookList, int low, int high, int choice)
{
    srand(time(0));
    int pivot, cmp, random = low + rand()%(high - low + 1);
    char strPivot[50];
    swap((bookList+random), (bookList+high));
    switch(choice)
    {

    case 1:
        strcpy(strPivot,(bookList+high)->bookName);
        break;//printf("\n%s %s\n",strPivot, (bookList+random)->bookName); break;
    case 2:
        strcpy(strPivot,(bookList+high)->authorName);
        break;//printf("\n%s %s\n",strPivot, (bookList+random)->authorName); break;
    case 3:
        pivot = (bookList+high)->edition;
        break;
    case 4:
        pivot = (bookList+high)->isbn;
        break;
    case 5:
        pivot = (bookList+high)->price;
        break;
    case 6:
        strcpy(strPivot,(bookList+high)->publication);
        break;
    case 7:
        pivot = (bookList+high)->year;
        break;
    default:
        printf("Invalid choice");
        exit(-1);

    }

    int i = (low - 1);

    for (int j = low; j <= high- 1; j++)
    {
        switch(choice)
        {

        case 1:
            if ((strcmp(strPivot,(bookList+j)->bookName))>=0)
            {
                i++;
                swap((bookList+i), (bookList+j));
            }
            break;
        case 2:
            if ((strcmp(strPivot,(bookList+j)->authorName))>=0)
            {
                //printf("\n%s %s\n",strPivot, (bookList+random)->authorName);
                i++;
                swap((bookList+i), (bookList+j));
            }
            break;
        case 3:
            if ((bookList+j)->edition <= pivot)
            {
                i++;
                swap((bookList+i), (bookList+j));
            }
            break;
        case 4:
            if ((bookList+j)->isbn <= pivot)
            {
                i++;
                swap((bookList+i), (bookList+j));
            }
            break;
        case 5:
            if ((bookList+j)->price <= pivot)
            {
                i++;
                swap((bookList+i), (bookList+j));
            }
            break;
        case 6:
            if((strcmp(strPivot,(bookList+j)->publication))>=0)
            {
                i++;
                swap((bookList+i), (bookList+j));
            }
            break;
        case 7:
            if ((bookList+j)->year <= pivot)
            {
                i++;
                swap((bookList+i), (bookList+j));
            }
            break;
        default:
            printf("Invalid choice");
            exit(-1);

        }

        /*if ((bookList+j)->year <= pivot)
            {
                i++;
                swap((bookList+i), (bookList+j));
            }*/
        }
        swap((bookList+i + 1), (bookList+high));
        return (i + 1);
    }


    void quickSort(struct book *bookList, int low, int high, int choice)
    {
        if (low < high)
        {
            int pi = partition(bookList, low, high, choice);

            quickSort(bookList, low, pi - 1, choice);
            quickSort(bookList, pi + 1, high, choice);
        }
    }

    void main()
    {
        int n, choice;
        printf("Enter number of books : ");
        scanf("%d",&n);
        struct book *bookList;
        bookList = (struct book*) malloc (n * sizeof(struct book));

        for(int i = 0; i < n; i++)
        {
            printf("Enter bookname, authorname, edition, isbn, price, publication, year respectively:\n");
            scanf("%s %s %d %d %d %s %d", &(bookList+i)->bookName, &(bookList+i)->authorName, &(bookList+i)->edition, &(bookList+i)->isbn, &(bookList+i)->price, &(bookList+i)->publication, &(bookList+i)->year);
        }


        printf("Displaying Information:\n");

        for(int i = 0; i < n ; ++i)
            printf("\n%s\t%s\t%d\t%d\t%d\t%s\t%d\n", (bookList+i)->bookName, (bookList+i)->authorName, (bookList+i)->edition, (bookList+i)->isbn, (bookList+i)->price, (bookList+i)->publication, (bookList+i)->year);

        //swap(bookList+0, bookList+1);




        printf("\nSelect the field by which you want to sort \n1. BookName \n2. AuthorName \n3. Edition \n4. ISBN \n5. Price \n6. Publication \n7. Year \n");
        scanf("%d",&choice);
        quickSort(bookList,0,n-1, choice);

        printf("Displaying Information after sorting based on choice %d:\n",choice);

        for(int i = 0; i < n ; ++i)
            printf("\n%s\t%s\t%d\t%d\t%d\t%s\t%d\n", (bookList+i)->bookName, (bookList+i)->authorName, (bookList+i)->edition, (bookList+i)->isbn, (bookList+i)->price, (bookList+i)->publication, (bookList+i)->year);



    }



