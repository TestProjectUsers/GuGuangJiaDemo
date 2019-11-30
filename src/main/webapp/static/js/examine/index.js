let vm = new Vue({
    el: "#main-container",
    data: function () {
        return {
            pageInfo: {
                pageNum: 1,
                pageSize: 5
            },
            setting: {
                data: {
                    key: {
                        title: "fullName"
                    },
                    simpleData: {
                        enable: true,
                        pIdKey: "parent_id"
                    }
                },
                callback: {
                    onClick: this.onClick
                },
                view: {
                    fontCss: this.setCss
                }

            },
            params: {
                pageNum: '',
                pageSize: '',
                userName: '',
                type:'',
                name:''
            },
            name: '',
            nodes: [],
            treeObj: {},
            node: ''
        }

    },
    methods: {
        /*selectCondition:function(){
            this.params.pageNum = this.pageInfo.pageNum
            this.params.pageSize = this.pageInfo.pageSize
            axios({
                url:"manager/examine/selectCondition",
                methods: "post",
                data:
            }).then().catch()
        },*/
        initTree: function () {
            axios({
                url: "manager/sysoffice/list"

            }).then(response => {
                this.nodes = response.data
                let treeobj = $.fn.zTree.init($("#pullDownTreeone"), this.setting, this.nodes)
                treeobj.expandAll(true)
                console.log(treeobj)
                this.treeObj = treeobj
                console.log(this.treeObj)

            }).catch(function (error) {
                console.log(error)
            })
        },
        selectAll: function (pageNum, pageSize) {
            this.params.pageNum = pageNum
            this.params.pageSize = pageSize
            axios({
                url: "manager/examine/select",
                method: "post",
                data:this.params
            }).then(response =>{
                this.pageInfo = response.data
                console.log(response.data)
            }).catch(function (error) {
                console.log(error)
            })
        },
        onClick: function (event, treeId, treeNode) {
            console.log(event)
            console.log(treeId)
            this.name = treeNode.name
            this.node = treeNode
        },
        setCss: function (treeId, treeNode) {
            return treeNode.highLine ? {
                color: "red"
            } : {
                color: ""
            }
        },
        search: function () {
            // let nodes = this.treeObj.getNodesByParamFuzzy("name", this.name, null)
            let nodes = this.treeObj.getNodesByParamFuzzy("name", this.name, null)
            let treeNodes = this.treeObj.transformToArray(this.treeObj.getNodes())

            for (let index in treeNodes) {
                treeNodes[index].highLine = false;
                this.treeObj.updateNode(treeNodes[index]);
            }

            for (let index in treeNodes) {
                console.log(treeNodes[index])
                for (let nodeIndex in nodes) {
                    if (treeNodes[index].id == nodes[nodeIndex].id) {
                        treeNodes[index].highLine = true;
                        this.treeObj.updateNode(treeNodes[index]);

                    }
                }
            }
        }
    },
    created: function () {
        this.selectAll(this.pageInfo.pageNum, this.pageInfo.pageSize);
    },
    mounted: function () {
        this.initTree();
    }
})