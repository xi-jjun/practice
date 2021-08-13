#include <stdio.h>
#include <limits.h>

int main(void) {
	printf("int type size : %d\n", sizeof(int));
	printf("long type size : %d\n", sizeof(long));
	printf("INT MAX : %d\n", INT_MAX);
	printf("Long MAX : %ld\n", LONG_MAX);
	printf("Long Long MAX : %lld\n", LLONG_MAX);

	return 0;
}
