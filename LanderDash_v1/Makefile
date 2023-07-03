# Java Makefile
# Dr Alun Moon
# alun.moon@northumbria.ac.uk

%.class:%.java
	javac $<

main:=LanderDash
jarfile:=LanderDash.jar
sources:=$(wildcard *.java)
assets=led-green.png led-grey.png led-orange.png led-red.png

classes=$(sources:%.java=%.class)
innerclasses=$(classes:%.class=%$\*.class)

all: tags $(jarfile)

jarfile: $(jarfile)

tags: $(sources)
	ctags --extra=fq $(sources)

$(jarfile): $(classes) $(assets)
	jar cfe $@ $(main) $(classes) $(innerclasses) $(assets)

.PHONY: clean
clean:
	rm -f *.class $(jarfile) tags *.orig

.PHONY: mostlyclean
mostlyclean:
	rm  -f *.class $(jarfile)

.PHONY: run
run: $(jarfile)
	java -jar $(jarfile) 

.PHONY: pretty
pretty: $(sources)
	astyle -q $(sources)
