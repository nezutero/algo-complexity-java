MAIN   ?= main.Main
SRC    := $(shell find src test -name '*.java' 2>/dev/null)
TESTS  := $(subst /,.,$(patsubst test/%.java,%,$(shell find test -name '*Test.java' 2>/dev/null)))
CP     := bin:lib/*
RLWRAP := $(shell command -v rlwrap 2>/dev/null)

.PHONY: build run debug test clean

build:
	javac -g -cp "lib/*" -d bin $(SRC)

run: build
	java -cp "$(CP)" $(MAIN)

debug: build
	$(RLWRAP) jdb -sourcepath src:test -classpath "$(CP)" $(MAIN)

test: build
	java -cp "$(CP)" org.junit.runner.JUnitCore $(TESTS)

clean:
	rm -rf bin
