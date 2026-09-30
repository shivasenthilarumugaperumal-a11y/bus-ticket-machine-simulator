#!/bin/bash
# test-db.sh
case "$(uname -s)" in
	MINGW*|MSYS*|CYGWIN*) CLASSPATH="bin;resources;lib/*" ;;
	*) CLASSPATH="bin:resources:lib/*" ;;
esac
java -cp "$CLASSPATH" com.tnstc.db.DBConnection