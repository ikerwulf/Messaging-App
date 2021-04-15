const express = require('express')
const router = express.Router()
const User = require('../models/User')


router.get('/', async (req, res) => {

    try {
        const Users = await User.find()
        res.json(Users)
    }catch(err){
        res.send('Error' + err)
    }
})

router.post('/', async(req, res) =>{
    const user = new User({
        name: req.body.name,
        email: req.body.email,
        password: req.body.password
    })

    try{
        const a1 = await user.save()
        res.json(a1)
    }catch(err){
        res.send('Error')
    }

})
module.exports = router