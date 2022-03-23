templates = [
  'banded_torch_white.json',
  'banded_torch_white_wall.json'
]

colors = [
  'orange',
  'magenta',
  'light_blue',
  'yellow',
  'lime',
  'pink',
  'gray',
  'light_gray',
  'cyan',
  'purple',
  'blue',
  'brown',
  'green',
  'red',
  'black'
]

for template in templates:
    original_file = open(template, 'r')
    original_lines = original_file.readlines()
    original_file.close()
    for color in colors:
        snake_case_color = color
        camel_case_color = ""
        camel_case_components = color.split('_')
        new_lines = []
        for component in camel_case_components:
            camel_case_color = camel_case_color + component.title()
        for original_line in original_lines:
            new_line = original_line.replace('white', snake_case_color).replace('White', camel_case_color)
            new_lines.append(new_line)
        new_file_name = template.replace('white', color)
        new_file = open(new_file_name, 'w')
        new_file.writelines(new_lines)
        new_file.close()
