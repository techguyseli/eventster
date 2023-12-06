import json

def load_json(file):
    with open(file, 'r') as f:
        json_obj = json.loads(f.read())
    return json_obj