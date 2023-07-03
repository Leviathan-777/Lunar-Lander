CC=gcc
LDFLAGS=-pthread -lcurses -lncurses
LIBS=libnet.o console_safe.o
CFLAGS=-Wall
SOURCES=libnet.c console_safe.c controller.c

help:
	@echo "make <target> where target is one of"
	@echo "        all:   everything"
	@echo "        run:   make and run 'control'"
	@echo " controller:   build the contoller program"
	@echo "       tags:   build the tags file with 'ctags'"
	@echo "               useful for navigating code in vim"
	@echo "      clean:   delete files that can be rebuilt"
	@echo "     pretty:   reformat the code with 'indent -kr'"
	@echo "       help:   show this help"
	@echo "consoledocs:   show the help man page for the console library"
	@echo "    netdocs:   show the help man page for the libnet library"

all: $(LIBS) controller

run: controller
	./controller 65200 65250

# controller: controller.c $(LIBS) 
controller: 
	$(CC) $(CFLAGS)   controller.c $(LIBS)   -o controller $(LDFLAGS)

.PHONY: consoledocs netdocs
consoledocs:
	groff -man -Tutf8 console.3 | less
netdocs:
	groff -man -Tutf8 libnet.3 | less

tags: $(SOURCES)
	ctags $?

.PHONY: clean pretty 

clean:
	rm -f $(LIBS) controller

pretty: $(SOURCES)
	indent -kr $?

