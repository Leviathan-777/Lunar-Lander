#ifndef _CONSOLE_H
#define _CONSOLE_H

/* some constants */
#include <curses.h>

int  console_init(void);  /* initialise LCD return sucess/fail */

/* LCD api */
void lcd_set_pos(int row, int column);
/*
0x00-0x07:  standard colors (as in ESC [ 30–37 m)
0x08-0x0F:  high intensity colors (as in ESC [ 90–97 m)
0x10-0xE7:  6 × 6 × 6 cube (216 colors): 16 + 36 × r + 6 × g + b (0 ≤ r, g, b ≤ 5)
0xE8-0xFF:  grayscale from black to white in 24 steps
*/
void lcd_set_colour(int foreground, int background);
void lcd_set_attr(int attributes);
void lcd_unset_attr(int attributes);
int  lcd_write(const char *fmt,...);
int  lcd_write_at(int row, int col, const char *fmt,...);

/* LED api */
typedef enum {
	LED_WHITE,
	LED_RED,
	LED_GREEN,
	LED_BLUE
} leds_t;

void led_on(leds_t led);
void led_off(leds_t led);
void led_toggle(leds_t led);

/* Button api */
int is_pressed(int button);
int key_pressed(void);
#endif

