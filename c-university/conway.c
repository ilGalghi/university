
#include <stdio.h>
#include <stdlib.h>
#include <math.h>
#include <stdbool.h>
#include <time.h>

#include "matrices.h"


Mat* game_of_life(Mat* mat);
void print_as_int(Mat* mat);


int main(void) {
	// Init
	Mat *m2;
	Mat *m = Mat_alloc(9, 9);
	m->row_ptrs[2][2] = 1;
	m->row_ptrs[3][2] = 1;
	m->row_ptrs[4][2] = 1;

	// Never leaves: use Ctrl-C
	while (true) {
		// Print
		puts("----------------");
		print_as_int(m);

		// Unefficient delay of 0.5s
		time_t start = time(NULL);
		while (difftime(time(NULL), start) < 0.5);

		// One step
		m2 = game_of_life(m);
		Mat_free(m);
		m = m2;
	}
}


// Utilities

bool is_live(Mat* mat, int r, int c) {
	if (r < 0 || r >= mat->rows) return false;
	if (c < 0 || c >= mat->cols) return false;
	return mat->row_ptrs[r][c] == 1;
}


void print_as_int(Mat* mat) {
	for (int r = 0; r < mat->rows; ++r) {
		for (int c = 0; c < mat->cols; ++c) {
			putchar((mat->row_ptrs[r][c] == 0.0)? ' ' : '#');
		}
		putchar('\n');
	}
}


// Soluzione
Mat* game_of_life(Mat* mat) {

	Mat *out = Mat_clone(mat);

	for (int r = 0; r < mat->rows; ++r) {
		for (int c = 0; c < mat->rows; ++c) {
			// conto le vicine
			int live_near = 0;
			if (is_live(mat, r, c+1)) ++live_near;
			if (is_live(mat, r-1, c+1)) ++live_near;
			if (is_live(mat, r-1, c)) ++live_near;
			if (is_live(mat, r-1, c-1)) ++live_near;
			if (is_live(mat, r, c-1)) ++live_near;
			if (is_live(mat, r+1, c-1)) ++live_near;
			if (is_live(mat, r+1, c)) ++live_near;
			if (is_live(mat, r+1, c+1)) ++live_near;

			// Regole del gioco
			bool this_is_live = is_live(mat, r, c);
			// Becomes live
			if (!this_is_live && live_near == 3) {
				out->row_ptrs[r][c] = 1.0;
				continue;
			}
			// Survives
			if (this_is_live && live_near >= 2 && live_near <= 3) {
				continue;
			}
			// Dies
			out->row_ptrs[r][c] = 0.0;
		}
	}

	return out;
}
