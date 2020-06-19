package main

import (
	"./input"
	"./output"
	"./processing"
)

func main() {
	var inputString string = input.Input()

	var processResult string = processing.Process(inputString)

	output.Output(processResult)
}
