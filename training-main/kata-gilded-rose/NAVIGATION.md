Navigation
==========

A sample solution is provided in the `sample-solution` branch.

You can navigate it step by step after defining the following git aliases in your .git/config file:

```ini
[alias]
        prev = checkout HEAD^1
        next = "!sh -c 'git log --reverse --pretty=%H sample-solution | awk \"/$(git rev-parse HEAD)/{getline;print}\" | xargs git checkout'"
```

You can then use the `git next` and `git prev` commands to navigate the `sample-solution` branch.

Have fun.