#! /bin/bash 
###########################################
#
###########################################

# constants
baseDir=$(cd `dirname "$0"`;pwd)
# functions

# main 
[ -z "${BASH_SOURCE[0]}" -o "${BASH_SOURCE[0]}" = "$0" ] || return
cd $baseDir/..
if [ -d tmp/lucene.spell-correction ]; then
    rm -rf tmp/lucene.spell-correction
fi
mkdir tmp/lucene.spell-correction

cd app
mvn test
