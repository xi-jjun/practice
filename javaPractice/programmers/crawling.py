# crwalingTest.py file
import requests
from bs4 import BeautifulSoup

def main():
    url = 'https://naver.com/'
    html = requests.get(url)  # url에 해당하는 HTML내용 가져오기.
    soup = BeautifulSoup(html.content, 'html.parser')  # 'soup'이라는 객체(object)생성
    select = soup.find_all('div', {'id': 'NM_FAVORITE'})
    # select = soup.head.find_all('meta')
    for meta in select:
        # if meta.get_text() != None:
        print(meta.get_text().strip().replace("\n","  "))
    # print(select.get_text())
    print(len(select))

if __name__ == '__main__':
    main()