<<<<<<< HEAD
maria.Model.subclass(checkit, 'TodoModel', {
    attributes: {
        content: {
            type: 'string',
            trim: true
        },
        done: {
            type: 'boolean'
        }
    }
});
=======
checkit.TodoModel = function() {
    maria.Model.apply(this, arguments);
};
checkit.TodoModel.superConstructor = maria.Model;
checkit.TodoModel.prototype = maria.create(maria.Model.prototype);
checkit.TodoModel.prototype.constructor = checkit.TodoModel;
checkit.TodoModel.prototype._content = '';
checkit.TodoModel.prototype._isDone = false;
checkit.TodoModel.prototype.getContent = function() {
    return this._content;
};
checkit.TodoModel.prototype.setContent = function(content) {
    content = checkit.trim('' + content);
    if (this._content !== content) {
        this._content = content;
        this.dispatchEvent({type: 'change'});
    }
};
checkit.TodoModel.prototype.isDone = function() {
    return this._isDone;
};
checkit.TodoModel.prototype.setDone = function(isDone) {
    isDone = !!isDone;
    if (this._isDone !== isDone) {
        this._isDone = isDone;
        this.dispatchEvent({type: 'change'});
    }
};
checkit.TodoModel.prototype.toggleDone = function() {
    this.setDone(!this.isDone());
};
/* maria.Model.subclass(checkit, 'TodoModel', {
    properties: {
        _content: '',
        _isDone: false,
        getContent: function() {
            return this._content;
        },
        setContent: function(content) {
            content = checkit.trim('' + content);
            if (this._content !== content) {
                this._content = content;
                this.dispatchEvent({type: 'change'});
            }
        },
        isDone: function() {
            return this._isDone;
        },
        setDone: function(isDone) {
            isDone = !!isDone;
            if (this._isDone !== isDone) {
                this._isDone = isDone;
                this.dispatchEvent({type: 'change'});
            }
        },
        toggleDone: function() {
            this.setDone(!this.isDone());
        }
    }
}); */
>>>>>>> fab843078f021ef3b851769d41e919077f540f72
