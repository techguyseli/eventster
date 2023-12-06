import requests
import sys
from jsonloader import load_json

header = load_json(sys.argv[1])
auth = (header["username"], header["password"])
link = header['link']
body = load_json(sys.argv[2])
r = requests.post(link, data=body, auth=auth)

print("Response Status Code:", r.status_code)
print("Response Body:", r.content)