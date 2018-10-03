#!/bin/bash

export langueNom="frFR"
export appliNom="${appliNom:-heytate-cardiac}"
export appliChemin="${appliChemin:-$(readlink -f $( dirname $( dirname $( dirname ${BASH_SOURCE[0]} ) ) ) )}"
export appliComputateChemin="${appliComputateChemin:-/usr/local/src/computate}"

source "$appliComputateChemin/bin/frFR/00-functions.sh"

$appliComputateChemin/bin/$langueNom/installer.sh
