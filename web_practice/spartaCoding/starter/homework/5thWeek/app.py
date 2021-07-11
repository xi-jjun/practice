import re
from flask import Flask, render_template, jsonify, request

app = Flask(__name__)

from pymongo import MongoClient

client = MongoClient('mongodb://test:test@localhost', 27017)
#client = MongoClient('localhost', 27017)
db = client.dbhomework


## HTML 화면 보여주기
@app.route('/')
def homework():
    return render_template('index.html')


# 주문하기(POST) API
@app.route('/order', methods=['POST'])
def save_order():
    name_receive = request.form['name_give']
    orders_receive = request.form['orders_give']
    address_receive = request.form['address_give']
    phoneNum_receive = request.form['phoneNum_give']

    doc = {
        'name':name_receive,
        'orders':orders_receive,
        'address':address_receive,
        'phoneNum':phoneNum_receive
    }

    db.myShopping.insert_one(doc) # mongoDB의 table 'myshopping'에 js로 부터 받은 정보 전송.
    
    return jsonify({'msg': 'Saved!!'})


# 주문 목록보기(Read) API
@app.route('/order', methods=['GET'])
def view_orders():
    orders = list(db.myShopping.find({},{'_id':False}))
    
    return jsonify({'all_orders':orders})


if __name__ == '__main__':
    app.run('0.0.0.0', port=5000, debug=True)
