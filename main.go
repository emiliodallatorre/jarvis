package main

import (
	"./input"
	"./output"
	"./processing"
)

func main() {
	var processor processing.Processor
	processor.Initialize()

	for
	{
		var inputString string = input.Input()

		processResult, processError := processor.Process(inputString)

		output.Output(processResult, processError)
	}
}
