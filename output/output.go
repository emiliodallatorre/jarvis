package output

import "fmt"
import "github.com/gookit/color"

func Output(output string, error error) {
	if output != "" {
		fmt.Println("Jarvis: " + output)
		fmt.Println()

		return
	}

	color.Error.Println(error)
}
